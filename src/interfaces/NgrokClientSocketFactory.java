package interfaces;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;

public class NgrokClientSocketFactory implements RMIClientSocketFactory, Serializable {
    private final int ngrokPort;

    public NgrokClientSocketFactory(int ngrokPort) {
        this.ngrokPort = ngrokPort;
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return new Socket(host, ngrokPort);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NgrokClientSocketFactory)) return false;
        return ngrokPort == ((NgrokClientSocketFactory) o).ngrokPort;
    }

    @Override
    public int hashCode() {
        return ngrokPort;
    }
}
