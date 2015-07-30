package br.com.peretz.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Rafael
 */
@FacesValidator(value = "passwordValidator")
public class PasswordValidator implements Validator{

     
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String pass = (String)value;
        
        if(pass.length() == 0){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha não pode ser nula", ""));
        }else if(pass.length() < 6){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha deve conter ao menos 6 caracteres", ""));
        }else if(pass.length() > 40){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha deve conter no máximo de 40 caracteres", ""));
        }
    }
    
}
