package co.com.system.invoice.constants;

import lombok.Getter;

@Getter
public enum DateFormats {

    DD_MM_YYYY("dd/MM/yyyy");

    private String value;

    private DateFormats(final String value) {
        this.value = value;
    }

}
