package com.springboot.backend.apirest.reclutamiento.constraint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.CharacterRule;
import org.passay.DictionaryRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.MessageResolver;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.PropertiesMessageResolver;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.passay.dictionary.WordListDictionary;
import org.passay.dictionary.WordLists;
import org.passay.dictionary.sort.ArraysSort;

import com.google.common.base.Joiner;

import org.apache.log4j.Logger;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String>{
	
	private static final Logger logger = Logger.getLogger(PasswordConstraintValidator.class);
	
	private DictionaryRule dictionaryRule;
	
	@Override
    public void initialize(ValidPassword constraintAnnotation) {
        try {
            String invalidPasswordList = this.getClass().getResource("/invalid-password-list.txt").getFile();
            dictionaryRule = new DictionaryRule(
                    new WordListDictionary(WordLists.createFromReader(
                            // lista de contraseñas no permitidas
                            new FileReader[] {
                                    new FileReader(invalidPasswordList)
                            },
                            // true para la distinción entre mayúsculas y minúsculas, false en caso contrario
                            false,
                            // Los diccionarios deben estar ordenados
                            new ArraysSort()
                    )));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar la lista de palabras ", e);
        }
    }
	
	
	
	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		
		URL resource = this.getClass().getClassLoader().getResource("passay-messages.properties");
		Properties props = new Properties();
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(resource.getPath()), "UTF-8");
			props.load(isr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MessageResolver resolver = new PropertiesMessageResolver(props);
		
		PasswordValidator validator = new PasswordValidator(resolver, Arrays.asList(
				
				// entre 8 y 100 caracteres
                new LengthRule(8, 100),

                // al menos un carácter en mayúscula
                new CharacterRule(EnglishCharacterData.UpperCase, 1),

                // al menos un carácter en minúscula
                new CharacterRule(EnglishCharacterData.LowerCase, 1),

                // al menos un carácter de dígito
                new CharacterRule(EnglishCharacterData.Digit, 1),

                // al menos un símbolo (carácter especial)
                new CharacterRule(EnglishCharacterData.Special, 1),

                // sin espacios
                new WhitespaceRule(),

                // sin contraseñas comunes
                dictionaryRule
				));
		
		RuleResult result = validator.validate(new PasswordData(password));
		logger.info("Result:" + validator.getMessages(result));
		
		if (result.isValid()) {
            return true;
        }
		
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(Joiner.on(",").join(validator.getMessages(result))).addConstraintViolation();
		
		return false;
	}

}
