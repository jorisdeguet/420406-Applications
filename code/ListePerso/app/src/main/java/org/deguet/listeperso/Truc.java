package org.deguet.listeperso;

/**
 * Created by joris on 17-01-12.
 */

public class Truc {

    public String a = "Pipo";

    public String b = "Popi";

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Truc{");
        sb.append("a='").append(a).append('\'');
        sb.append(", b='").append(b).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
