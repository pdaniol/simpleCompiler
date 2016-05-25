package compiler;

import compiler.generator.CodeGenerator;
import compiler.generator.Operation;

import java.util.List;
import java.util.Scanner;

/**
 * Created by patrycja on 24.05.16.
 */
public class MainClass {
    public static void main(String[] args) {

//        System.out.println("Enter operation (+ and * allowed):");
        Scanner scanner = new Scanner(System.in);
        String userInput=scanner.nextLine();
        List<Token> tokens;


        if(!Tokenizer.checkInput(userInput))
            System.out.println("wrong input!");
        else {
            tokens = Tokenizer.findTokens(userInput);
            if (!Tokenizer.checkTokens(tokens))
                System.out.println("wrong input!");
            else {
                Parser parser = new Parser(tokens);
                ParserTreeNode rootNode = parser.parseAdd();

                CodeGenerator codeGenerator = new CodeGenerator();
                List<Operation> envCommands = codeGenerator.parseSyntacticTree(rootNode);

                envCommands.forEach(c -> System.out.println(c.toString()));
            }
        }
    }
}
