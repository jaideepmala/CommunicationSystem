package com.amazon.hfchotel.test.communicationManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amazon.hfchotel.test.communicationManagement.bo.Request;
import com.amazon.hfchotel.test.communicationManagement.enums.RequestType;

public class RequestDAO {

    public void addRequest(Request request) throws SQLException {

        String query = "INSERT INTO requests (requestId, type, content, recipient, timestamp, providerId) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, request.getRequestId());
            stmt.executeUpdate();
        }
    }

    // Method to retrieve a Request by ID
    public Request getRequestById(String requestId) throws SQLException {

        String query = "SELECT * FROM requests WHERE requestId = ?";
        Request request = null;

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, requestId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                request = new Request(
                    rs.getString("requestId"),
                    (RequestType) rs.getObject("recipient"),
                    rs.getString("providerId")
                );
            }
        }
        return request;
    }

    // Method to update a Request
    public void updateRequest(Request request) throws SQLException {

        String query = "UPDATE requests SET type = ?, content = ?, recipient = ?, timestamp = ?, providerId = ? WHERE requestId = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setTimestamp(4, request.getTimestamp());
            stmt.setString(6, request.getRequestId());
            stmt.executeUpdate();
        }
    }

    // Method to delete a Request
    public void deleteRequest(String requestId) throws SQLException {

        String query = "DELETE FROM requests WHERE requestId = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, requestId);
            stmt.executeUpdate();
        }
    }

    // Method to get all Requests
    public List<Request> getAllRequests() throws SQLException {

        String query = "SELECT * FROM requests";
        List<Request> requests = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Request request = new Request(
                    rs.getString("requestId"),
                    (RequestType) rs.getObject("recipient"),
                    rs.getString("providerId")
                );
                requests.add(request);
            }
        }
        return requests;
    }
}
