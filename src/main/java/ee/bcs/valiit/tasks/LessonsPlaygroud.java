package ee.bcs.valiit.tasks;

public class LessonsPlaygroud {
    public static void main(String[] args) {
        int a = 4;
        int b = 5;

        b = a + b;
        a = b-a;
        b = b -a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        Book bookA = new Book();
        bookA.setTitle("Minu lugu");

    }



//String currency = "135.69";
//System.out.println(new BigDecimal(currency));


//    git --version
//    git

//    cd change directory
//    cd Desktop
//    mkdir git-test
//    cd git-test
//    cd ..
//    "tab" -näitab olemasolevaid kaustasid, kui tühi siis ei näita midagi
//    dir
//    git init
//    põhimõte on working dir -> staging area -> repo
//    git status
//    git add file.extention
//    git commit -m "initial test"


}
