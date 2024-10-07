package com.aditya.DesignPattern.lld.linkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionService {

    private Map<String, Connection> connectionMap;

    public ConnectionService() {
        connectionMap = new HashMap<>();
    }

    public Connection addConnection(String senderUserId, String receiverUserId) {
        Connection connection = new Connection(senderUserId, receiverUserId);
        connectionMap.put(connection.getConnectionId(), connection);
        return connection;
    }

    public void acceptConnection(String connectionId) {
        Connection connection = connectionMap.get(connectionId);
        connection.setAccepted(true);
    }

    public List<Connection> getAllMyAcceptedConnection(String userId) {
        List<Connection> acceptedConnections = new ArrayList<>();

        for (Connection connection : connectionMap.values()) {
            if (connection.isAccepted() && (connection.getSenderUserId().equals(
                    userId) || connection.getReceiverUserId().equals(userId))) {
                acceptedConnections.add(connection);
            }
        }

        return acceptedConnections;
    }

    public List<Connection> getAllUnacceptedConnectionsOfReceiver(String userId) {
        List<Connection> acceptedConnections = new ArrayList<>();

        for (Connection connection : connectionMap.values()) {
            if (!connection.isAccepted() && connection.getReceiverUserId().equals(userId)) {
                acceptedConnections.add(connection);
            }
        }

        return acceptedConnections;
    }

    public List<Connection> getAllUnacceptedConnectionsOfSender(String userId) {
        List<Connection> acceptedConnections = new ArrayList<>();

        for (Connection connection : connectionMap.values()) {
            if (!connection.isAccepted() && connection.getSenderUserId().equals(userId)) {
                acceptedConnections.add(connection);
            }
        }

        return acceptedConnections;
    }
}
