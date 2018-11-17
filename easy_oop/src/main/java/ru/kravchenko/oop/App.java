package ru.kravchenko.oop;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person[] personsList =  new Person[5];
        personsList[0] = new Person(
                "Eugene Kravchenko",
                "QA Automation Lead",
                "2909kev@gmail.com",
                "+79533370587",
                150000, 28);
        personsList[1] = new Person(
                "Eugene Solncev",
                "QA tester",
                "2909kev@gmail.com",
                "+79533370587",
                100000, 40);
        personsList[2] = new Person(
                "Ivan Molodcov",
                "QA Automation",
                "2909kev@gmail.com",
                "+79533370587",
                140000, 39);
        personsList[3] = new Person(
                "Vladimir Kravchenko",
                "QA",
                "2909kev@gmail.com",
                "+79533370587",
                80000, 45);
        personsList[4] = new Person(
                "Eugene OLDER",
                "retiree",
                "2909kev@gmail.com",
                "+79533370587",
                20000, 65);

        for (Person aPersonsList : personsList) {
            if (aPersonsList.getAge() >= 40) {
                System.out.println(aPersonsList.getFullInformation());
            }
        }
    }
}
