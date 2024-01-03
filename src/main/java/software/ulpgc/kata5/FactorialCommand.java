package software.ulpgc.kata5;
import java.util.stream.LongStream;

import static software.ulpgc.kata5.Command.output;

public class FactorialCommand implements Command{
    @Override
    public Output execute(Input input) {
        try{
            return factorial(input.get("number"));
        } catch(NumberFormatException e){
            return output(400, "Not a number");
        }
    }

    private Output factorial(String number) {
        return factorial(Integer.parseInt(number));
    }

    private Output factorial(int number) {
        if(number > 20) return output(400, "Number out of bounds");
        long factorial = LongStream.range(2, number + 1).reduce(1, (acum, i) -> acum * i);
        return output(200, String.valueOf(factorial));
    }
}
