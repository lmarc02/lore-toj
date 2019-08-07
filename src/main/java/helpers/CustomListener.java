package helpers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;


public class CustomListener implements ITestListener {
    private static int count = 1;
    final static String FILE_PATH = "/Users/loredana.marc/Documents/workspace/lore-toj/src/test/resources/report.html";

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult tr) {
        writeToHtmlFile(tr.getName(), tr.getMethod().getDescription(), "Fail");

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        writeToHtmlFile(tr.getName(), tr.getMethod().getDescription(), "Skipped");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        writeToHtmlFile(tr.getName(), tr.getMethod().getDescription(), "Pass");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onFinish(ITestContext context) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true));
            bw.write("</tbody>\n" +
                              "</table>\n" +
                              "\n" +
                              "</div> <!-- /container -->\n" +
                              "</body>\n" +
                              "</html>");
            bw.close();
        } catch (Exception e) {
            System.out.println("We couldn't write to the file.");
        }
    }

    @Override
    public void onStart(ITestContext context) {
        try {
            File file = new File(FILE_PATH);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                bw.write("<!DOCTYPE html>");
                bw.write("<head>");
                bw.write("<title>Test Report</title>");
                bw.write("<link href=\"bootstrap.min.css\" rel=\"stylesheet\">");
                bw.write("</head>");
                bw.write("<body><div class=\"container\"><br>");
                bw.write("<h3>Test reports</h3><br>");

                bw.write("<table class=\"table table-hover\">\n" +
                                  "  <thead style=\"background-color:#E6E6E6;\">\n" +
                                  "    <tr>");
                bw.write("<th scope=\"col\">#</th>\n" +
                                  "      <th scope=\"col\">Test name</th>\n" +
                                  "      <th scope=\"col\">Test description</th>\n" +
                                  "      <th scope=\"col\">Result</th>\n" +
                                  "    </tr>\n" +
                                  "  </thead><tbody>");
                bw.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred. The file couldn't be created");
            e.printStackTrace();
        }
    }

    public static void writeToHtmlFile(String testName, String testDescription, String testResult){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true));
            if (testResult.equals("Fail"))
                bw.write("<tr style=\"background-color:#f4cccc;\">\n");
            else if (testResult.equals("Pass"))
                bw.write("<tr style=\"background-color:#d9ead3;\">\n");
            else
                bw.write("<tr>\n");

            bw.write("<th scope=\"row\">" + count + "</th>");
            bw.write("<td>" + testName + "</td>");
            bw.write("<td>" + testDescription + "</td>");
            bw.write("<td>" + testResult + "</td>");
            bw.write("</tr>");
            bw.close();



        } catch (Exception e) {
            System.out.println("We couldn't write to the file.");
        }

        count++;
    }
}
