package Vista;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class VistaInstrucciones extends ScrollPane{
	
	public VistaInstrucciones(){
		this.getStyleClass().add("instrucciones");
		this.setPadding(new Insets(10));
		
		Label label = new Label("Instrucciones");
		label.getStyleClass().add("titulo");
		
		Label instrucciones = new Label();
		instrucciones.getStyleClass().add("texto");
		instrucciones.setWrapText(true);
		instrucciones.setMaxWidth(780);
		
		Path path = null;
		try {
			path = Paths.get(getClass().getResource("txt/instruccion.txt").toURI());
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		try {
			Files.lines(path, StandardCharsets.ISO_8859_1).forEach(v->{
				instrucciones.setText(instrucciones.getText() + "\n" + v);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		instrucciones.getStyleClass().add("titulo");
		VBox vBox = new VBox();
		vBox.getChildren().addAll(label,instrucciones);
		
		this.setContent(vBox);
		this.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
	}
	
}
