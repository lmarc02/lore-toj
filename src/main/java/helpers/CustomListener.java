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
    private int m_count = 0;
    final static String FILE_PATH = "/Users/tudor.ilut/projects/lore-toj/src/test/resources/report.html";

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult tr) {
        log("F");
        tr.getMethod().getDescription();
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log("S");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        writeToHtmlFile(tr.getName(), tr.getMethod().getDescription(), "Pass");
    }

    private void log(String string) {
        System.out.print(string);
        if (++m_count % 40 == 0) {
            System.out.println("");
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    };

    public void onFinish(ITestContext context) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FILE_PATH, true));
            out.write("</tbody>\n" +
                              "</table>\n" +
                              "\n" +
                              "</div> <!-- /container -->\n" +
                              "</body>\n" +
                              "</html>");
        } catch (Exception e) {
            System.out.println("We couldn't write to the file.");
        }
    };

    @Override
    public void onStart(ITestContext context) {
        try {
            File file = new File(FILE_PATH);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
                out.write("<!DOCTYPE html>");
                out.write("<head>");
                out.write("<title>Test Report</title>");
                out.write("<link href=\"bootstrap.min.css\" rel=\"stylesheet\">");
                out.write("</head>");

                out.write("<body><div class=\"container\"><br>");
                out.write("<h3>Test reports</h3><br>");

                out.write("<table class=\"table table-hover\">\n" +
                                  "  <thead>\n" +
                                  "    <tr>");
                out.write("<th scope=\"col\">#</th>\n" +
                                  "      <th scope=\"col\">Test name</th>\n" +
                                  "      <th scope=\"col\">Test description</th>\n" +
                                  "      <th scope=\"col\">Result</th>\n" +
                                  "    </tr>\n" +
                                  "  </thead><tbody>");
                out.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeToHtmlFile(String testName, String testDescription, String testResult){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FILE_PATH, true));
            out.write("<tr>\n" +
                              "      <th scope=\"row\">1</th>");
            out.write("<td>" + testName + "</td>");
            out.write("<td>" + testDescription + "</td>");
            out.write("<td>" + testResult + "</td>");
            out.write("</tr>");
        } catch (Exception e) {
            System.out.println("We couldn't write to the file.");
        }
    }
}
