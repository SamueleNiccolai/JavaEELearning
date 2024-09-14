package cdi.sessionbeans;

import java.io.Serializable;
import java.text.MessageFormat;

import javax.ejb.Stateful;

import cdi.annotations.ServiceMan;
import cdi.interfaces.Salute;

@Stateful
@ServiceMan(value = ServiceMan.ServiceType.POLICE)
@cdi.annotations.Police
public class Police implements Salute, Serializable {
    @Override
    public String salute(String name) {
        return MessageFormat.format("Yes sir! {0}", name);
    }
}
