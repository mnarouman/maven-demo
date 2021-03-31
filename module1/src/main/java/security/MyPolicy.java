package security;

import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Policy;

class MyPolicy extends Policy {
    @Override
    public PermissionCollection getPermissions(CodeSource codesource) {
        return null;
    }

    @Override
    public void refresh() {
    }

    public String someAppleToString(Object o) {
        return ((MyPolicy) o).toString();
    }
}