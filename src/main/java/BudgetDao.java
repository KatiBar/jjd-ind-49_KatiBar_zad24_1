import java.sql.*;

public class BudgetDao {

    public void insert(Budget budget) {
        Connection connection = connect();

        PreparedStatement preparedStatement;
        try {
            String sql = "INSERT INTO homebudget(type, description, amount, date) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, budget.getType());
            preparedStatement.setString(2, budget.getDescription());
            preparedStatement.setDouble(3, budget.getAmount());
            preparedStatement.setString(4, budget.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas zapisu do bazy danych: " + e.getMessage());
        }

        closeConnection(connection);
    }

    public void update(Budget budget) {
        Connection connection = connect();

        PreparedStatement preparedStatement;
        try {
            String sql = "UPDATE homebudget SET type = ?, description = ?, amount = ?, date = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, budget.getType());
            preparedStatement.setString(2, budget.getDescription());
            preparedStatement.setDouble(3, budget.getAmount());
            preparedStatement.setString(4, budget.getDate());
            preparedStatement.setLong(5, budget.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas aktualizowania bazy danych: " + e.getMessage());
        }

        closeConnection(connection);
    }

    public void delete(long id) {
        Connection connection = connect();

        PreparedStatement preparedStatement;
        try {
            String sql = "DELETE FROM homebudget WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas usuwania z bazy danych: " + e.getMessage());
        }

        closeConnection(connection);
    }

    public double calculateSum(String type) {
        Connection connection = connect();

        PreparedStatement preparedStatement;
        try {
            String sql = "SELECT SUM(amount) FROM homebudget WHERE type = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas wyświetlania danych z bazy: " + e.getMessage());
        }
        closeConnection(connection);
        return 0;
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/budget?serverTimezone=UTC&characterEncoding=utf8", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
