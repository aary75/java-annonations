package com.bridgelabz.javaAnnonation;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
    BugReport[] value();
}

class Bug{

    @BugReport(description = "Bug is found")
    @BugReport(description = "It is in software permissions")
    public void display(){
        System.out.print("Problem solved");
    }
}

public class BugReportRepeatAbleAnnonation {
    public static void main(String[] args) throws Exception{

        Method method = Bug.class.getMethod("display");
        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

        for(BugReport bugReport : bugReports){
            System.out.println(bugReport.description());
        }
    }
}
