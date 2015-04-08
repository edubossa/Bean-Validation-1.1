package br.com.ews.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<Cep, String> {
	
	private Pattern pattern = Pattern.compile("[0-9]{5}-[0-9]{3}");
	
	public void initialize(Cep constraintAnnotation) {
		System.out.println(constraintAnnotation);
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) return false;
		Matcher m = pattern.matcher(value);
		return m.matches();
	}

}