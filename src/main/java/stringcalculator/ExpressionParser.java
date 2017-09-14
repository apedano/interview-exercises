package stringcalculator;

import stringcalculator.operation.ExpressionStack;

/**
 * Created by Alex on 29/08/2017.
 */
public class ExpressionParser {

    /**
     * Il metodo cerca di applicare il parser all'espressione corrente, eventualmente pushando nello stack
     * sub operazioni che vanno effettuate
     * @param current l'espressione corrente
     * @param stack lo stack delle esressioni risolte
     * @return null se current non rappresenta un'operazione singola cui il risultato è l'eventuale valore
     */
    public static Double resolve(Expression current, ExpressionStack stack){
        return 0.0;
    }

}
