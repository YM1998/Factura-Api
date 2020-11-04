package co.com.system.invoice.translators;


/**
 * Design concept
 *
 * @author Carvajal
 * @version 1.0
 * @since 2020-04-13
 * @param <I> input
 * @param <O> output
 */

public interface Translator<I, O> {

    O translate(final I input);

}
