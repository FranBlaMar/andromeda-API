package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.ApartadoWiki;
import com.example.demo.model.InfoWiki;
import com.example.demo.repository.ApartadoWikiRepository;
import com.example.demo.repository.InfoWikiRepository;

@SpringBootApplication
public class AndromedaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndromedaApiApplication.class, args);
	}

	
	@Bean
	CommandLineRunner initData(ApartadoWikiRepository repositorioApartado,InfoWikiRepository repositorioInfo) {
		return args -> {
			List<InfoWiki> infoPlanetas = Arrays.asList(
					new InfoWiki("Mercurio", "Es el más cercano al Sol, a parte de ser el más pequeño de sus homólogos. Tiene parecido con la Tierra, "
							+ "ya que se compone de un 70% de elementos metálicos y un 30% restante de silicatos. Además, al igual que la Luna, Mercurio "
							+ "presenta una gran cantidad de crateres generados por el impacto de meteoritos. Mercurio cuenta con terrenos escarpados y lisos, así como acantilados, "
							+ "algunas de estas formaciones se extienden por varios cientos de kilómetros y tienen hasta 1 milla de altura. "
							+ "A diferencia de la Luna, Mercurio cuenta con zonas de hielo."
							+ "La temperatura de Mercurio durante el día pueden alcanzar los 430° Celsius y durante la noche -180° Celsius.", "mercurio.png"),
					new InfoWiki("Venus", "A Venus es el segundo planeta más cercano al Sol. Dentro de los Planetas "
							+ "del Sistema Solar, Venus suele denominarse como el planeta “hermano de la Tierra” debido a su gran parecido, tanto en tamaño como "
							+ "en masa y su composición de tipo rocoso y terrestre. Pese a situarse más lejos del Sol que Mercurio, Venus posee la atmósfera más "
							+ "caliente del sistema solar, esto se debe a que está compuesta principalmente por gases de efecto invernadero, como el dióxido de carbono, "
							+ "atrapando mucho más calor del Sol. Actualmente carece de agua líquida y sus condiciones en superficie se consideran incompatibles con la vida conocida.", "venus.jpg"),
					new InfoWiki("Tierra", "El planeta Tierra, nuestro planeta, es el mayor de los denominados planetas rocosos. Se formó hace unos 4600 millones de años y su nombre proviene del latín “Terra”, "
							+ "deidad griega que corresponde a la feminidad y fecundidad. El 71% de su composición corresponde a la hidrosfera (agua), hecho diferencial que ha permitido "
							+ "la existencia y persistencia de la vida humana. Ningún otro planeta del Sistema Solar contiene tal nivel de líquido."
							+ " Las propiedades físicas de la Tierra, la historia geológica y su órbita han permitido que la vida siga existiendo. Se estima que el planeta seguirá siendo capaz de sustentar "
							+ "vida durante otros 500 millones de años, ya que según las previsiones actuales, pasado ese tiempo la creciente luminosidad del Sol terminará causando la extinción de la biosfera.", "tierra.jpg"),
					new InfoWiki("Marte", "Marte es el segundo de los planetas del Sistema solar de menor tamaño, después de Mercurio. Desde hace tiempo es comúnmente conocido como “planeta rojo”, fruto del color "
							+ "rojizo que adquiere por el óxido de hierro en la mayoría de su superficie. Su tamaño es casi la mitad del de la Tierra y su gravedad un 40% menor, lo cual lo hace prácticamente "
							+ "inhabitable según las últimas investigaciones de la NASA. Marte posee dos satélites pequeños y de forma irregular, Fobos y Deimos (hijos del dios griego Marte), que podrían ser asteroides capturados", "marte.jpg"),
					new InfoWiki("Jupiter", "El Planeta del Sistema Solar que recibe su nombre por el Dios Zeus de la mitología griega (Júpiter en mitología romana) es, precedido por el Sol, el planeta con mayor cuerpo celeste."
							+ " Tiene un tamaño de 1300 veces mayor que la Tierra. Como cuerpo masivo gaseoso, su composición está formada básicamente de hidrógeno y hielo. Como dato curioso, es considerado el planeta más antiguo del "
							+ "Sistema Solar, precediendo al Sol inclusive."
							+ "El planeta es conocido por una enorme formación meteorológica, la Gran Mancha Roja, fácilmente visible por astrónomos aficionados dado su gran tamaño, superior al de la Tierra. Su atmósfera está "
							+ "permanentemente cubierta de nubes que permiten trazar la dinámica atmosférica y muestran un alto grado de turbulencia.", "jupiter.jpg"),
					new InfoWiki("Saturno", "Es famoso este planeta del Sistema Solar por su imponente brillo procedente de sus anillos que rodean al planeta. Volviendo a Galileo, éste lo avistó por primera vez en el año 1610. "
							+ "Prácticamente todo el planeta (un 96%) está formado por hidrógeno y el 3% restante de hielo. Las partículas que componen los anillos de Saturno giran a una velocidad de 48.000 km/h, 15 veces más rápido que una bala.", "saturno.jpg"),
					new InfoWiki("Urano", "Este planeta está considerado el primero en ser descubierto mediante un telescopio. Su composición es muy parecida a la de sus hermanos Saturno y Júpiter, puesto que está formado por "
							+ "helio e hidrógeno, así como de agua, amoníaco y metano pero en cantidades mayores. Una peculiaridad de este planeta del Sistema Solar es su atmósfera, con las temperaturas más bajas de todo el Sistema, "
							+ "alcanzando la mínima de -224 grados Celsius. Asimismo, tiene una estructura de nubes muy compleja, acomodada por niveles, donde se cree que las nubes más bajas están compuestas de agua y las más altas de metano. "
							+ "En contraste, el interior de Urano se encuentra compuesto principalmente de hielo y roca.", "urano.jpg"),
					new InfoWiki("Neptuno", "Neptuno fue descubierto hace unos dos siglos por Urbain Le Verrier, John Couch y Johann Galle, allá por el año 1847. No obstante, algunos historiadores y astrónomos sostienen que el célebre Galileo "
							+ "Galilei ya observó este planeta por el año 1612, dato todavía sin confirmar. El planeta Neptuno está compuesto de roca fundida, agua, metano, hidrógeno, hielo y amoníaco líquido."
							+ "Neptuno es un planeta dinámico, con manchas que recuerdan las tempestades de Júpiter. La más grande, la Gran Mancha Oscura, tenía un tamaño similar al de la Tierra, pero en 1994 desapareció y se ha formado otra. "
							+ "Los vientos más fuertes de cualquier planeta del sistema solar se encuentran en Neptuno.", "neptuno.jpg")
					);
					ApartadoWiki planetas = new ApartadoWiki("Planetas");
					planetas.setInformacion(infoPlanetas);
					ApartadoWiki galaxias = new ApartadoWiki("Galaxias");
					ApartadoWiki satelites = new ApartadoWiki("Satélites");
					ApartadoWiki estrellas = new ApartadoWiki("Estrellas");
					ApartadoWiki fenomenos = new ApartadoWiki("Fenómenos Astronómicos");
			repositorioApartado.saveAll( Arrays.asList(planetas, galaxias, satelites, estrellas, fenomenos));
		};
	}
}
