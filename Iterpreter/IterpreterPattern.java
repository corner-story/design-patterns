import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IterpreterPattern {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = null;
        try{
            System.out.print(">>> ");
            while ((input = scan.nextLine()) != null) {
                if(input.equals("exit")){
                    break;
                }
                System.out.println(new Context(input));
                System.out.println(new Expr().parse(new Context(input)));
                System.out.print(">>> ");
            }

        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}

// 使用Iterpreter模式做一个简单的计算器
/*
    BNF:

    Expr := Term + Expr | Term - Expr
    Term := Factor * Term | Factor / Term
    Factor := i | (Expr)

*/
class Context{
    private List<String> tokens;
    private int index = 0;
    public Context(String input){
        this.tokens = parse(input);
    }

    private List<String> parse(String input){
        return Arrays.asList(input.split(" "));
    }

    public String current(){
        if(index < this.tokens.size()){
            return this.tokens.get(index);
        }
        return null;
    }

    public void advance(){
        this.index++;
    }

    public String toString(){
        return "Context[ tokens: [" + this.tokens.toString() + " ] ]";
    }
}


abstract class Node{
    public abstract double parse(Context context) throws Exception;
}

class Expr extends Node{

    public double parse(Context context) throws Exception{
        Node left = new Term();
        double leftvalue = left.parse(context);
        if(context.current() == null || (!context.current().equals("+") && !context.current().equals("-"))){
            return leftvalue;
        }

        Node right = new Expr();
        String op = "+";
        if(context.current().equals("-")){
            op = "-";
        }
        context.advance();
        double rightvalue = right.parse(context);
        
        if(op.equals("+")){
            return leftvalue + rightvalue;
        }
        return leftvalue - rightvalue;
    }
}

class Term extends Node{

    public double parse(Context context) throws Exception{
        Node left = new Factor();
        double leftvalue = left.parse(context);
        if(context.current() == null || (!context.current().equals("*") && !context.current().equals("/"))){
            return leftvalue;
        }

        Node right = new Term();
        String op = "*";
        if(context.current().equals("/")){
            op = "/";
        }
        context.advance();
        double rightvalue = right.parse(context);

        if(op.equals("*")){
            return leftvalue * rightvalue;
        }
        return leftvalue / rightvalue;
    }
}


class Factor extends Node{

    public double parse(Context context) throws Exception{
        
        if(context.current() == null){
            throw new Exception("error: current is null!");
        }
        if(Character.isDigit(context.current().charAt(0))){
            String v = context.current();
            context.advance();
            return Double.valueOf(v);

        }else if(context.current().charAt(0) == '('){
            context.advance();
            Node vaule = new Expr();
            double res = vaule.parse(context);

            if(context.current().charAt(0) != ')'){
                throw new Exception("it need a ')'");
            }
            context.advance();
            context.advance();
            return res;
        }

        throw new Exception("unknow factor: " + context.current());
    }
}