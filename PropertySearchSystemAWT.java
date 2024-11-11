import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import java.util.List;
import java.util.stream.Collectors;

class PropertySearchSystemAWT extends Frame {
    PropertyManager propertyManager = new PropertyManager();
    Image backgroundImage;
    PropertySearchSystemAWT() {
        setLayout(new FlowLayout());
        setSize(400, 200);
        setTitle("Property Search System");
        setBackground(new Color(220, 220, 220)); // Light gray background
        try {
            backgroundImage = ImageIO.read(new File("estate.jpg")); // Ensure the file path is correct
        } catch (IOException e) {
            System.err.println("Error loading background image: " + e.getMessage());
        }
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10)); // 1 row, 3 columns
        Button searchButton = new Button("Search Property");
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        searchButton.addActionListener(e -> new SearchPropertyPage(propertyManager));
        buttonPanel.add(searchButton);
        Button addPropertyButton = new Button("Add Property");
        addPropertyButton.setFont(new Font("Arial", Font.BOLD, 16));
        addPropertyButton.addActionListener(e -> new AddPropertyPage(propertyManager));
        buttonPanel.add(addPropertyButton);
        Button viewPropertiesButton = new Button("View Properties");
        viewPropertiesButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewPropertiesButton.addActionListener(e -> new ViewPropertiesPage(propertyManager));
        buttonPanel.add(viewPropertiesButton);
        add(buttonPanel);
        populateSampleProperties();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    void populateSampleProperties() {
    propertyManager.addProperty(new Property(1, "Mumbai", 15000000, 900, 19.076, 72.8777, "Residential", "Beautiful 2BHK with sea view"));
    propertyManager.addProperty(new Property(2, "Delhi", 12000000, 1200, 28.6139, 77.2090, "Commercial", "Prime location for office space"));
    propertyManager.addProperty(new Property(3, "Erode - Gandhigramam", 3000000, 800, 11.3415, 77.7241, "Residential", "Affordable 2BHK near schools"));
    propertyManager.addProperty(new Property(4, "Erode - Bhavani", 4000000, 1000, 11.5849, 77.7056, "Residential", "Modern 3BHK with garden space"));
    propertyManager.addProperty(new Property(5, "Erode - Chennimalai", 5000000, 1200, 11.3563, 77.6421, "Residential", "Spacious 4BHK with a beautiful view"));
    propertyManager.addProperty(new Property(6, "Erode - Perundurai", 2500000, 700, 11.3781, 77.6755, "Residential", "Cozy 1BHK ideal for small families"));
    propertyManager.addProperty(new Property(7, "Erode - Modakurichi", 3500000, 850, 11.3325, 77.6967, "Commercial", "Shop space in busy market area"));
    propertyManager.addProperty(new Property(8, "Erode - Thindal", 6000000, 1500, 11.3683, 77.7246, "Commercial", "Office space in prime location"));
    propertyManager.addProperty(new Property(9, "Erode - Erode Town", 4500000, 900, 11.3410, 77.7220, "Residential", "Family home with modern amenities"));
    propertyManager.addProperty(new Property(10, "Erode - Kumarapalayam", 2000000, 600, 11.4224, 77.7060, "Residential", "Budget-friendly studio apartment"));
    propertyManager.addProperty(new Property(11, "Erode - Vellode", 8000000, 1600, 11.3075, 77.6558, "Residential", "Luxurious villa with pool"));
    propertyManager.addProperty(new Property(12, "Erode - Kootapalli", 4500000, 1100, 11.3450, 77.7434, "Commercial", "Retail space in new shopping complex"));
    propertyManager.addProperty(new Property(13, "Mumbai", 15000000, 900, 19.076, 72.8777, "Residential", "Beautiful 2BHK with sea view"));
    propertyManager.addProperty(new Property(14, "Delhi", 12000000, 1200, 28.6139, 77.2090, "Commercial", "Prime location for office space"));
    propertyManager.addProperty(new Property(15, "Chennai", 9000000, 1000, 13.0827, 80.2707, "Residential", "Modern apartment with all amenities"));
    propertyManager.addProperty(new Property(16, "Bangalore", 16000000, 1800, 12.9716, 77.5946, "Residential", "Luxury villa in a gated community"));
    propertyManager.addProperty(new Property(17, "Coimbatore", 7500000, 1100, 11.0168, 76.9558, "Residential", "Spacious flat near IT park"));
    propertyManager.addProperty(new Property(18, "Erode", 3000000, 800, 11.3415, 77.7241, "Residential", "Affordable 2BHK in a quiet neighborhood"));
    propertyManager.addProperty(new Property(19, "Erode", 4000000, 1000, 11.3415, 77.7241, "Residential", "Modern 3BHK with garden space"));
    propertyManager.addProperty(new Property(20, "Erode", 5000000, 1200, 11.3415, 77.7241, "Residential", "Spacious 4BHK near schools"));
    propertyManager.addProperty(new Property(21, "Erode", 2500000, 700, 11.3415, 77.7241, "Residential", "Cozy 1BHK ideal for small families"));
    propertyManager.addProperty(new Property(22, "Erode", 3500000, 850, 11.3415, 77.7241, "Commercial", "Shop space in busy market area"));
    propertyManager.addProperty(new Property(23, "Erode", 6000000, 1500, 11.3415, 77.7241, "Commercial", "Office space in prime location"));
    propertyManager.addProperty(new Property(24, "Erode", 4500000, 900, 11.3415, 77.7241, "Residential", "Family home with modern amenities"));
    propertyManager.addProperty(new Property(25, "Erode", 2000000, 600, 11.3415, 77.7241, "Residential", "Budget-friendly studio apartment"));
    propertyManager.addProperty(new Property(26, "Erode", 8000000, 1600, 11.3415, 77.7241, "Residential", "Luxurious villa with pool"));
    propertyManager.addProperty(new Property(27, "Erode", 4500000, 1100, 11.3415, 77.7241, "Commercial", "Retail space in new shopping complex"));
    propertyManager.addProperty(new Property(28, "Mumbai", 15000000, 900, 19.076, 72.8777, "Residential", "Beautiful 2BHK with sea view"));
    propertyManager.addProperty(new Property(29, "Delhi", 12000000, 1200, 28.6139, 77.2090, "Commercial", "Prime location for office space"));
    propertyManager.addProperty(new Property(30, "Chennai", 9000000, 1000, 13.0827, 80.2707, "Residential", "Modern apartment with all amenities"));
    propertyManager.addProperty(new Property(31, "Bangalore", 16000000, 1800, 12.9716, 77.5946, "Residential", "Luxury villa in a gated community"));
    propertyManager.addProperty(new Property(32, "Coimbatore", 7500000, 1100, 11.0168, 76.9558, "Residential", "Spacious flat near IT park"));
    }
    public static void main(String[] args) {
        new PropertySearchSystemAWT();
    }
}
class Property {
    int id;
    String location;
    double price;
    double area;
    double latitude;
    double longitude;
    String type;
    String description;

    public Property(int id, String location, double price, double area, double latitude, double longitude, String type, String description) {
        this.id = id;
        this.location = location;
        this.price = price;
        this.area = area;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               "\nLocation: " + location +
               "\nPrice: ₹" + price +
               "\nArea: " + area + " sq ft" +
               "\nLatitude: " + latitude +
               "\nLongitude: " + longitude +
               "\nType: " + type +
               "\nDescription: " + description + "\n";
    }

    public double getPrice() {
        return price;
    }

    public double getArea() {
        return area;
    }
}

class PropertyManager {
    private Map<Integer, Property> propertyMap = new HashMap<>();
    private TreeMap<Double, List<Property>> priceIndex = new TreeMap<>();
    private List<Property> cachedSearchResults = new ArrayList<>();

    void addProperty(Property property) {
        propertyMap.put(property.id, property);
        priceIndex.putIfAbsent(property.price, new ArrayList<>());
        priceIndex.get(property.price).add(property);
    }

    List<Property> searchByPriceRange(double minPrice, double maxPrice) {
        List<Property> results = new ArrayList<>();
        priceIndex.subMap(minPrice, maxPrice).values().forEach(results ::addAll);
        return results;
    }

    List<Property> searchByAreaRange(double minArea, double maxArea) {
        List<Property> results = new ArrayList<>();
        for (Property property : propertyMap.values()) {
            if (property.area >= minArea && property.area <= maxArea) {
                results.add(property);
            }
        }
        return results;
    }

    List<Property> multiCriteriaSearch(double minPrice, double maxPrice, double minArea, double maxArea, String location, String type) {
        List<Property> priceFiltered = searchByPriceRange(minPrice, maxPrice);
        List<Property> areaFiltered = searchByAreaRange(minArea, maxArea);

        Set<Property> resultSet = new HashSet<>(priceFiltered);
        resultSet.retainAll(areaFiltered); // Retain only properties that match both criteria

        List<Property> finalResults = new ArrayList<>();
        for (Property property : resultSet) {
            boolean matchesLocation = location.isEmpty() || property.location.toLowerCase().contains(location.toLowerCase());
            boolean matchesType = type.equals("All") || property.type.equalsIgnoreCase(type);
            if (matchesLocation && matchesType) {
                finalResults.add(property);
            }
        }

        cachedSearchResults = finalResults; // Cache results for the view properties page
        return finalResults;
    }
    List<Property> getAllProperties() {
        return new ArrayList<>(propertyMap.values());
    }
    List<Property> getCachedSearchResults() {
        return cachedSearchResults;
    }
    List<Property> findNearbyProperties(double latitude, double longitude, double maxDistanceKm) {
        List<Property> nearbyProperties = new ArrayList<>();
        for (Property property : propertyMap.values()) {
            double distance = calculateDistance(latitude, longitude, property.latitude, property.longitude);
            if (distance <= maxDistanceKm) {
                nearbyProperties.add(property);
            }
        }
        return nearbyProperties;
    }
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in km
    }
}
class SearchPropertyPage extends Frame {
    private final PropertyManager propertyManager;
    private final TextField locationField;
    private final TextArea resultArea;

    SearchPropertyPage(PropertyManager propertyManager) {
        this.propertyManager = propertyManager;

        setLayout(new GridBagLayout());
        setSize(400, 300);
        setTitle("Search Properties");
        setBackground(new Color(230, 230, 250)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addComponent(gbc, 0, 0, new Label("Location:"), locationField = new TextField(20));
        Button searchButton = new Button("Search");
        searchButton.addActionListener(e -> searchProperties());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(searchButton, gbc);
        resultArea = new TextArea(10, 40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font for results
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(resultArea, gbc);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }
    private void addComponent(GridBagConstraints gbc, int x, int y, Component label, TextField textField) {
        gbc.gridx = x;
        gbc.gridy = y;
        label.setFont(new Font("Arial", Font.BOLD, 14)); // Font for labels
        textField.setFont(new Font("Arial", Font.PLAIN, 14)); // Font for text fields
        add(label, gbc);
        gbc.gridx = x + 1;
        add(textField, gbc);
    }
    private void searchProperties() {
        String location = locationField.getText().trim();
        List<Property> results = propertyManager.getAllProperties().stream()
            .filter(property -> property.location.toLowerCase().contains(location.toLowerCase()))
            .collect(Collectors.toList());
        displayResults(results);
    }
    private void displayResults(List<Property> results) {
        resultArea.setText(""); // Clear previous results
        if (results.isEmpty()) {
            resultArea.setText("No properties found.");
        } else {
            for (Property property : results) {
                resultArea.append(property.toString() + "\n--------------------------------\n");
            }
        }
    }
}
class AddPropertyPage extends Frame {
    private final PropertyManager propertyManager;
    private final TextField locationField, priceField, areaField, latitudeField, longitudeField, typeField, descriptionField;
    AddPropertyPage(PropertyManager propertyManager) {
        this.propertyManager = propertyManager;
        setLayout(new GridBagLayout());
        setSize(400, 400);
        setTitle("Add Property");
        setBackground(new Color(240, 240, 240)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addComponent(gbc, 0, 0, new Label("Location:"), locationField = new TextField(20));
        addComponent(gbc, 0, 1, new Label("Price:"), priceField = new TextField(10));
        addComponent(gbc, 0, 2, new Label("Area (sq ft):"), areaField = new TextField(10));
        addComponent(gbc, 0, 3, new Label("Latitude:"), latitudeField = new TextField(10));
        addComponent(gbc, 0, 4, new Label("Longitude:"), longitudeField = new TextField(10));
        addComponent(gbc, 0, 5, new Label("Type:"), typeField = new TextField(10));
        addComponent(gbc, 0, 6, new Label("Description:"), descriptionField = new TextField(40));
        setFontForComponents();
        Button addButton = new Button("Add Property");
        addButton.addActionListener(e -> addProperty());
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(addButton, gbc);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }
    private void addComponent(GridBagConstraints gbc, int x, int y, Component label, TextField textField) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(label, gbc);
        gbc.gridx = x + 1;
        add(textField, gbc);
    }
    private void setFontForComponents() {
        for (Component component : getComponents()) {
            if (component instanceof Label) {
                component.setFont(new Font("Arial", Font.BOLD, 14));
            } else if (component instanceof TextField) {
                component.setFont(new Font("Arial", Font.PLAIN, 14));
            }
        }
    }
    private void addProperty() {
        try {
            String location = locationField.getText().trim();
            double price = parseDouble(priceField.getText().trim(), "Price must be a valid number.");
            double area = parseDouble(areaField.getText().trim(), "Area must be a valid number.");
            double latitude = parseDouble(latitudeField.getText().trim(), "Latitude must be a valid number.");
            double longitude = parseDouble(longitudeField.getText().trim(), "Longitude must be a valid number.");
            String type = typeField.getText().trim();
            String description = descriptionField.getText().trim();
            int id = propertyManager.getAllProperties().size() + 1; // Simple ID assignment
            Property property = new Property(id, location, price, area, latitude, longitude, type, description);
            propertyManager.addProperty(property);
            clearFields();
            System.out.println("Property added successfully!");
        } catch (IllegalArgumentException e) {
            // Display error message in console (could also be a popup)
            System.err.println("Error: " + e.getMessage());
        }
    }
    private double parseDouble(String input, String errorMessage) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    private void clearFields() {
        locationField.setText("");
        priceField.setText("");
        areaField.setText("");
        latitudeField .setText("");
        longitudeField.setText("");
        typeField.setText("");
        descriptionField.setText("");
    }
}
class ViewPropertiesPage extends Frame {
    PropertyManager propertyManager;
    TextArea displayArea;
    Choice sortChoice;
    Choice filterChoice;
    TextField searchField;
    Button filterButton;
    Button sortButton;
    Label propertyCountLabel;
    ViewPropertiesPage(PropertyManager propertyManager) {
        this.propertyManager = propertyManager;
        setLayout(new BorderLayout());
        setSize(800, 600);
        setTitle("View Properties");
        setBackground(new Color(240, 240, 240));
        displayArea = new TextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 14));
        add(displayArea, BorderLayout.CENTER);
        Panel controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());
        sortChoice = new Choice();
        sortChoice.add("Sort By");
        sortChoice.add("Price (Low to High)");
        sortChoice.add("Price (High to Low)");
        sortChoice.add("Area (Low to High)");
        sortChoice.add("Area (High to Low)");
        controlPanel.add(sortChoice);
        filterChoice = new Choice();
        filterChoice.add("All Types");
        filterChoice.add("Residential");
        filterChoice.add("Commercial");
        controlPanel.add(filterChoice);
        searchField = new TextField(15);
        controlPanel.add(searchField);
        filterButton = new Button("Filter");
        filterButton.addActionListener(e -> applyFilters());
        controlPanel.add(filterButton);
        sortButton = new Button("Sort");
        sortButton.addActionListener(e -> applySorting());
        controlPanel.add(sortButton);
        propertyCountLabel = new Label("Total Properties: " + propertyManager.getAllProperties().size());
        controlPanel.add(propertyCountLabel);
        add(controlPanel, BorderLayout.NORTH);
        displayProperties(propertyManager.getAllProperties());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
        setVisible(true);
    }
    void displayProperties(List<Property> properties) {
        displayArea.setText(""); // Clear previous content
        if (properties.isEmpty()) {
            displayArea.setText("No properties available.");
        } else {
            for (Property property : properties) {
                displayArea.append(property.toString() + "\n--------------------------------\n");
            }
            propertyCountLabel.setText("Total Properties: " + properties.size());
        }
    }
    void applyFilters() {
        String selectedType = filterChoice.getSelectedItem();
        String searchText = searchField.getText().trim().toLowerCase();
        List<Property> filteredProperties = propertyManager.getAllProperties();
        if (!selectedType.equals("All Types")) {
            filteredProperties.removeIf(p -> !p.type.equalsIgnoreCase(selectedType));
        }
        if (!searchText.isEmpty()) {
            filteredProperties.removeIf(p -> !p.location.toLowerCase().contains(searchText));
        }
        displayProperties(filteredProperties);
    }
    void applySorting() {
        String selectedSort = sortChoice.getSelectedItem();
        List<Property> properties = propertyManager.getAllProperties();
        switch (selectedSort) {
            case "Price (Low to High)":
                properties.sort(Comparator.comparingDouble(p -> p.price));
                break;
            case "Price (High to Low)":
                properties.sort(Comparator.comparingDouble(Property::getPrice).reversed());
                break;
            case "Area (Low to High)":
                properties.sort(Comparator.comparingDouble(p -> p.area));
                break;
            case "Area (High to Low)":
                properties.sort(Comparator.comparingDouble(Property::getArea).reversed());
                break;
        }

        displayProperties(properties);
    }
}