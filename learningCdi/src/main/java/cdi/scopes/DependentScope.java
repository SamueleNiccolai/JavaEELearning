package cdi.scopes;

import java.io.Serializable;

public class DependentScope implements Serializable {

    public String getHashCode() {
        return this.hashCode() + " ";
    }
}
