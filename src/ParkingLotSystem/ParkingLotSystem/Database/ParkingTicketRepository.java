package ParkingLotSystem.ParkingLotSystem.Database;

import ParkingLotSystem.Models.ParkingLot;
import ParkingLotSystem.Models.ParkingTicket;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ParkingTicketRepository {
    private HashMap<ParkingLot, HashMap<String, ParkingTicket>> allParkingTickets;

    public ParkingTicketRepository() {
        allParkingTickets = new HashMap<>();
    }

    // Getter for allParkingTickets structure
    public HashMap<ParkingLot, HashMap<String, ParkingTicket>> getParkingTicketsStructure() {
        return new HashMap<>(allParkingTickets);
    }

    // Setter for allParkingTickets structure
    public void setParkingTicketsStructure(HashMap<ParkingLot, HashMap<String, ParkingTicket>> allParkingTickets) {
        this.allParkingTickets = new HashMap<>(allParkingTickets);
    }

    // Get all parking tickets as a List
    public List<ParkingTicket> getAllParkingTickets() {
        List<ParkingTicket> allTickets = new ArrayList<>();
        for (HashMap<String, ParkingTicket> parkingLotTickets : allParkingTickets.values()) {
            allTickets.addAll(parkingLotTickets.values());
        }
        return allTickets;
    }

    // Add a new parking lot
    public void addParkingLot(ParkingLot parkingLot) {
        if (!allParkingTickets.containsKey(parkingLot)) {
            allParkingTickets.put(parkingLot, new HashMap<>());
        }
    }

    // Remove a parking lot
    public void removeParkingLot(ParkingLot parkingLot) {
        allParkingTickets.remove(parkingLot);
    }

    // Add a ticket to a specific parking lot
    public void addTicket(ParkingLot parkingLot, String ticketId, ParkingTicket ticket) {
        allParkingTickets.computeIfAbsent(parkingLot, k -> new HashMap<>()).put(ticketId, ticket);
    }

    // Remove a ticket from a specific parking lot
    public void removeTicket(ParkingLot parkingLot, String ticketId) {
        if (allParkingTickets.containsKey(parkingLot)) {
            allParkingTickets.get(parkingLot).remove(ticketId);
        }
    }

    // Get all tickets for a specific parking lot
    public List<ParkingTicket> getTicketsForParkingLot(ParkingLot parkingLot) {
        return new ArrayList<>(allParkingTickets.getOrDefault(parkingLot, new HashMap<>()).values());
    }

    // Get a specific ticket from a specific parking lot
    public ParkingTicket getTicket(ParkingLot parkingLot, String ticketId) {
        return allParkingTickets.getOrDefault(parkingLot, new HashMap<>()).get(ticketId);
    }

    // Get total number of tickets across all parking lots
    public int getTotalTicketCount() {
        return allParkingTickets.values().stream()
                .mapToInt(Map::size)
                .sum();
    }
}