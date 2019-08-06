package helpers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Listener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        writeToHtml("The name of the testcase passed is :"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        writeToHtml("The name of the testcase failed is :" + result.getStatus());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
       writeToHtml("The name of the testcase Skipped is :"+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        try {
            File myObj = new File("/Users/loredana.marc/Documents/workspace/lore-toj/src/test/resources/report.html");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        writeToHtml(context.getName()+ " test case started");
    }

    public void writeToHtml(String testResult){
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        try {
            fWriter = new FileWriter("/Users/loredana.marc/Documents/workspace/svauto/src/test/resources/report.html");
            writer = new BufferedWriter(fWriter);
            writer.write("<span>"+ testResult +"</span>");
            writer.newLine(); //this is not actually needed for html files - can make your code more readable though
            writer.close(); //make sure you close the writer object
        } catch (Exception e) {
            //catch any exceptions here
        }
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
