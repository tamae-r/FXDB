package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaFXMLController {
	@FXML
	private Label id;
	@FXML
	private Label nome;
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtNome;
	
	@FXML
	private void initialize () {}
	
	@FXML
	public void actionMensagem (ActionEvent event) {
		id.setText(txtId.getText());
		nome.setText(txtNome.getText());
	}
	@FXML
	public void actionSQLSelect (ActionEvent event) {
		try {
			DBUtil db = DBUtil.getInstance();
			PreparedStatement ps = db.getConnection().prepareStatement("Select * from aluno");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id")+"-"+rs.getString("nome"));
			}
		} catch (Exception e) {
			System.out.println("Erro: "+e.toString());
		}
		
	}
	
	@FXML
	public void actionSQLInsert (ActionEvent event) {
		try {
			DBUtil db = DBUtil.getInstance();
			PreparedStatement ps = db.getConnection().prepareStatement("Insert into aluno (id, nome) values (?, ?)");
			ps.setInt(1, Integer.parseInt(txtId.getText()));
			ps.setString(2, txtNome.getText());
			ps.execute();
		} catch (Exception e) {
			System.out.println("Erro: "+e.toString());
		}
	}

}
