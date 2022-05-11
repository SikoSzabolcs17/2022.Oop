package oop.labor11.labor11_4;

public interface IExpression {

     static double evaluate(String expressions) throws ExpressionException {
         double result = 0;
         Stack stack = new Stack(4);
         String[] items = expressions.split(" ");

         for( String item: items ) {
             item = item.trim();

             if( isOperator(item)){

                 try{
                     double operand1 = (double)stack.top();
                     stack.pop();
                     double operand2 = (double) stack.top();
                     stack.top();
                     switch( item ){
                         case "+": stack.push(operand1 + operand2); break;
                         case "-": stack.push(operand1 - operand2); break;
                         case "*": stack.push(operand1 * operand2); break;
                         case "/": stack.push(operand2 / operand1); break;
                     }
                 }catch( StackException e ){
                     throw new ExpressionException("Wrong postfix expression");
                 }
             }
             else{
                 try{
                     stack.push( Double.parseDouble(item));
                 }catch(NumberFormatException e ){
                     throw new ExpressionException("Wrong operand: " + item);
                 }
                 catch (StackException e){
                     throw new ExpressionException("Stack is Full");
                 }
             }
         }
         try{
             return (double)stack.top();
         }catch( StackException e ){
             throw new ExpressionException("Wrong postfix expression");
         }
     }


    static boolean isOperator(String operator){
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }


}
