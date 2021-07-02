package co.com.system.invoice.translators;

public interface TranslatorReference<I, O> {


  public void translateReference(final I input, final O output);
}
