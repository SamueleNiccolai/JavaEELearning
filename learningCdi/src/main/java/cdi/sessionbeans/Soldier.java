package cdi.sessionbeans;

import java.text.MessageFormat;

import javax.ejb.Stateless;

import cdi.annotations.ServiceMan;
import cdi.interfaces.Salute;

@Stateless
@ServiceMan(value = ServiceMan.ServiceType.SOLDIER)
@cdi.annotations.Soldier
public class Soldier implements Salute {

    @Override
    public String salute(String name) {
        return MessageFormat.format("Aye Aye Capt {0}", name);
    }

}
