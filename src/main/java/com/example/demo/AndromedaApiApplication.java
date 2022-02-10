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
import com.example.demo.repository.NoticiaRepository;

@SpringBootApplication
public class AndromedaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndromedaApiApplication.class, args);
	}

	
	@Bean
	CommandLineRunner initData(ApartadoWikiRepository repositorioApartado, NoticiaRepository repositorioNoticia) {
		return args -> {
			List<InfoWiki> infoPlanetas = Arrays.asList(
					new InfoWiki("mercurio", "Es el más cercano al Sol, a parte de ser el más pequeño de sus homólogos. Tiene parecido con la Tierra, "
							+ "ya que se compone de un 70% de elementos metálicos y un 30% restante de silicatos. Además, al igual que la Luna, Mercurio "
							+ "presenta una gran cantidad de crateres generados por el impacto de meteoritos. Mercurio cuenta con terrenos escarpados y lisos, así como acantilados, "
							+ "algunas de estas formaciones se extienden por varios cientos de kilómetros y tienen hasta 1 milla de altura. "
							+ "A diferencia de la Luna, Mercurio cuenta con zonas de hielo."
							+ "La temperatura de Mercurio durante el día pueden alcanzar los 430° Celsius y durante la noche -180° Celsius.", "mercurio.png"),
					new InfoWiki("venus", "A Venus es el segundo planeta más cercano al Sol. Dentro de los Planetas "
							+ "del Sistema Solar, Venus suele denominarse como el planeta “hermano de la Tierra” debido a su gran parecido, tanto en tamaño como "
							+ "en masa y su composición de tipo rocoso y terrestre. Pese a situarse más lejos del Sol que Mercurio, Venus posee la atmósfera más "
							+ "caliente del sistema solar, esto se debe a que está compuesta principalmente por gases de efecto invernadero, como el dióxido de carbono, "
							+ "atrapando mucho más calor del Sol. Actualmente carece de agua líquida y sus condiciones en superficie se consideran incompatibles con la vida conocida.", "venus.jpg"),
					new InfoWiki("tierra", "El planeta Tierra, nuestro planeta, es el mayor de los denominados planetas rocosos. Se formó hace unos 4600 millones de años y su nombre proviene del latín “Terra”, "
							+ "deidad griega que corresponde a la feminidad y fecundidad. El 71% de su composición corresponde a la hidrosfera (agua), hecho diferencial que ha permitido "
							+ "la existencia y persistencia de la vida humana. Ningún otro planeta del Sistema Solar contiene tal nivel de líquido."
							+ " Las propiedades físicas de la Tierra, la historia geológica y su órbita han permitido que la vida siga existiendo. Se estima que el planeta seguirá siendo capaz de sustentar "
							+ "vida durante otros 500 millones de años, ya que según las previsiones actuales, pasado ese tiempo la creciente luminosidad del Sol terminará causando la extinción de la biosfera.", "tierra.jpg"),
					new InfoWiki("marte", "Marte es el segundo de los planetas del Sistema solar de menor tamaño, después de Mercurio. Desde hace tiempo es comúnmente conocido como “planeta rojo”, fruto del color "
							+ "rojizo que adquiere por el óxido de hierro en la mayoría de su superficie. Su tamaño es casi la mitad del de la Tierra y su gravedad un 40% menor, lo cual lo hace prácticamente "
							+ "inhabitable según las últimas investigaciones de la NASA. Marte posee dos satélites pequeños y de forma irregular, Fobos y Deimos (hijos del dios griego Marte), que podrían ser asteroides capturados", "marte.jpg"),
					new InfoWiki("jupiter", "El Planeta del Sistema Solar que recibe su nombre por el Dios Zeus de la mitología griega (Júpiter en mitología romana) es, precedido por el Sol, el planeta con mayor cuerpo celeste."
							+ " Tiene un tamaño de 1300 veces mayor que la Tierra. Como cuerpo masivo gaseoso, su composición está formada básicamente de hidrógeno y hielo. Como dato curioso, es considerado el planeta más antiguo del "
							+ "Sistema Solar, precediendo al Sol inclusive."
							+ "El planeta es conocido por una enorme formación meteorológica, la Gran Mancha Roja, fácilmente visible por astrónomos aficionados dado su gran tamaño, superior al de la Tierra. Su atmósfera está "
							+ "permanentemente cubierta de nubes que permiten trazar la dinámica atmosférica y muestran un alto grado de turbulencia.", "jupiter.jpg"),
					new InfoWiki("saturno", "Es famoso este planeta del Sistema Solar por su imponente brillo procedente de sus anillos que rodean al planeta. Volviendo a Galileo, éste lo avistó por primera vez en el año 1610. "
							+ "Prácticamente todo el planeta (un 96%) está formado por hidrógeno y el 3% restante de hielo. Las partículas que componen los anillos de Saturno giran a una velocidad de 48.000 km/h, 15 veces más rápido que una bala.", "saturno.jpg"),
					new InfoWiki("urano", "Este planeta está considerado el primero en ser descubierto mediante un telescopio. Su composición es muy parecida a la de sus hermanos Saturno y Júpiter, puesto que está formado por "
							+ "helio e hidrógeno, así como de agua, amoníaco y metano pero en cantidades mayores. Una peculiaridad de este planeta del Sistema Solar es su atmósfera, con las temperaturas más bajas de todo el Sistema, "
							+ "alcanzando la mínima de -224 grados Celsius. Asimismo, tiene una estructura de nubes muy compleja, acomodada por niveles, donde se cree que las nubes más bajas están compuestas de agua y las más altas de metano. "
							+ "En contraste, el interior de Urano se encuentra compuesto principalmente de hielo y roca.", "urano.jpg"),
					new InfoWiki("neptuno", "Neptuno fue descubierto hace unos dos siglos por Urbain Le Verrier, John Couch y Johann Galle, allá por el año 1847. No obstante, algunos historiadores y astrónomos sostienen que el célebre Galileo "
							+ "Galilei ya observó este planeta por el año 1612, dato todavía sin confirmar. El planeta Neptuno está compuesto de roca fundida, agua, metano, hidrógeno, hielo y amoníaco líquido."
							+ "Neptuno es un planeta dinámico, con manchas que recuerdan las tempestades de Júpiter. La más grande, la Gran Mancha Oscura, tenía un tamaño similar al de la Tierra, pero en 1994 desapareció y se ha formado otra. "
							+ "Los vientos más fuertes de cualquier planeta del sistema solar se encuentran en Neptuno.", "neptuno.jpg")
					);
			List<InfoWiki> infoGalaxias = Arrays.asList(
					new InfoWiki ("galaxia", "Mucho antes de que el Sistema Solar se formara, ya existían galaxias en el Universo. Este es un sistema que consta de múltiples elementos como las estrellas, los asteroides, los cuásares, los agujeros negros, "
							+ "los planetas, el polvo cósmico y las galaxias, entre muchos otros. Las galaxias son enormes grupos o sistemas espaciales compuestos por gases, polvo, estrellas y materia oscura, todo lo cual se mantiene unido mediante la gravedad. "
							+ "El número de galaxias es tremendamente grande y es por ahora imposible de saber exactamente. Los científicos han detectado miles de millones de galaxias en el universo observable, pero existe un número indeterminado ahí en donde los aparatos "
							+ "tecnológicos aún no alcanzan a llegar u observar.", ""),
					new InfoWiki("elíptica", "Su estrechez a lo largo de un eje les confiere una apariencia elíptica. Se componen de las estrellas más viejas y suelen encontrarse en los cúmulos de galaxias. Las galaxias más grandes de las que se tiene conocimiento son elípticas, "
							+ "pero las hay también pequeñas.",""),
					new InfoWiki("espiral", "Presentan una forma en espiral. Consisten en una especie de disco aplanado con “brazos” alrededor que le dan su forma, y en su parte media se concentra una gran cantidad de energía. Las estrellas, los planetas, "
							+ "el gas y el polvo giran alrededor del brillante centro. Las galaxias espirales barradas tienen “brazos” muy largos y el centro adquiere forma alargada, más parecida a una barra que a un círculo. Es justo en el centro donde se cree que nacen "
							+ "las estrellas.",""),
					new InfoWiki("irregular", " No tienen una morfología clara o distinguible y tienden a poseer estrellas jóvenes.", ""),
					new InfoWiki("lenticular","Es una forma que se encuentra a medio camino entre la espiral y la elíptica. Consisten en un disco sin “brazos” con poca materia interestelar, "
							+ "aunque algunas pueden presentar cierta cantidad.", "" ),
					new InfoWiki("peculiar", " Como su nombre sugiere, son galaxias de forma extraña, inusual; o raras en términos de composición o tamaño.", ""),
					new InfoWiki("origen", "El origen de las galaxias es un tema aún discutido. Los astrónomos creen que comenzaron a formarse poco después del Bing Bang, la explosión cósmica que dio origen al Universo, según la teoría del mismo nombre. En la etapa posterior a "
							+ "la explosión, las nubes de gases se unieron y comprimieron debido a la gravedad, lo que constituyó una primera parte de las galaxias. Después, las estrellas pudieron concentrarse formando cúmulos globulares para dar paso a las galaxias, o quizá se "
							+ "formaron primero estas y las estrellas contenidas se agruparon más tarde. Dichas galaxias jóvenes eran más pequeñas que ahora y se localizaban más juntas unas de las otras, pero al colisionar entre sí y ser parte de la expansión del universo, crecieron "
							+ "y modificaron su forma.", "")
					);
			List<InfoWiki> infoSatelites = Arrays.asList(
					new InfoWiki("satelite", "En astronomía, un satélite es un objeto que orbita (da vueltas) alrededor de un planeta. Hay centenares de satélites naturales, o lunas, en nuestro sistema solar, pero, desde 1957, también se han lanzado al espacio miles "
							+ "de satélites artificiales (fabricados por el hombre). Estos tienen usos muy diversos, como captar imágenes del Sol, la Tierra y otros planetas, o explorar el espacio para estudiar los agujeros negros, y las estrellas y galaxias remotas. También están "
							+ "los satélites de comunicaciones, los satélites meteorológicos y la Estación Espacial Internacional.", ""),
					new InfoWiki("satelite artificial", "Es cualquier objeto no natural que orbita alrededor de un cuerpo celeste. Estos objetos tienen una intención específica, pero todos persiguen el mismo fin: entender mejor el universo. A diferencia de los satélites naturales "
							+ "como la luna, los satélites artificiales son construidos por los seres humanos y se mueven en torno al objeto que es más grande que ellos. Generalmente son máquinas muy sofisticadas que se envían al espacio exterior, por lo que los desechos o restos "
							+ "de otras máquinas, las naves tripuladas, las estaciones orbitales y las sondas interplanetarias no son satélites artificiales.", ""),
					new InfoWiki("satelite natural", "Un satélite natural es un cuerpo celeste que orbita alrededor de un planeta. Generalmente el satélite es más pequeño y acompaña al planeta en su órbita alrededor de su estrella madre. A diferencia de los fragmentos que orbitan formando un anillo, "
							+ "es el único cuerpo en su órbita. El término satélite natural se contrapone al de satélite artificial, siendo este último un objeto que gira en torno a la Tierra, la Luna o algunos planetas y que ha sido fabricado por el ser humano. En el caso de la Luna, que tiene una "
							+ "masa aproximada a 1/81 de la masa de la Tierra, podría considerarse como un sistema de dos planetas que orbitan juntos (sistema binario de planetas). Tal es el caso de Plutón y su satélite Caronte. Si dos objetos poseen masas similares, se suele hablar de sistema binario "
							+ "en lugar de un objeto primario y un satélite. El criterio habitual para considerar un objeto como satélite es que el centro de masas del sistema formado por los dos objetos esté dentro del objeto primario. El punto más elevado de la órbita del satélite se conoce como apoápside. "
							+ "Por extensión se llama lunas a los satélites de otros planetas. Se dice «los cuatro satélites de Júpiter», pero también, «las cuatro lunas de Júpiter». También por extensión se llama satélite natural o luna a cualquier cuerpo natural que gira alrededor de un cuerpo celeste, "
							+ "aunque no sea un planeta, como es el caso del satélite asteroidal Dáctilo que gira alrededor del asteroide Ida.", "")
					
					);
			List<InfoWiki> infoEstrellas = Arrays.asList(
					new InfoWiki("estrella", "Las estrellas son motores de energía cósmica que producen calor, luz, rayos ultravioleta, rayos X y otras formas de radiación. Están compuestas casi en su totalidad de gas y plasma, un estado de supercalentamiento de la materia compuesta de partículas subatómicas."
							+ " Aunque la estrella más conocida, el Sol, existe en solitario, tres de cada cuatro estrellas existen como parte de un sistema binario compuesto por dos estrellas orbitando mutuamente. Nadie sabe cuántas estrellas existen, pero podrían alcanzar un número extraordinario. Nuestro"
							+ " universo podría albergar más de 100 000 millones de galaxias, y cada una de ellas podría tener más de 100 000 millones de estrellas. Tan sólo en una noche clara, desde la Tierra pueden observarse alrededor de 3000 estrellas a simple vista. Los humanos de diferentes culturas han "
							+ "dibujado el cielo mediante estas estrellas.", ""),
					new InfoWiki("apariencia", "Algunas estrellas han sobresalido siempre del resto. Su brillo es un factor de cuanta energía despiden, lo cual se conoce como su luminosidad, y también la distancia a la que se encuentran de la Tierra. Las estrellas del cielo también pueden parecer de diferentes"
							+ " colores porque sus temperaturas no son iguales. Las estrellas calientes son blancas o azules, mientras que las más frías parecen tener tonos rojos o anaranjados. Un par de prismáticos de tamaño 7x50 puede ser ideal para observar las estrellas. Si prefieres los telescopios, los refractores "
							+ "y los reflectores, que enfocan la luz estelar con espejos, son los más comunes. Que tengan lentes de alta calidad y un conjunto de tres oculares que puedas usar para cambiar el aumento son las características más importantes para poder observar tranquilamente "
							+ "las estrellas.", ""),
					new InfoWiki("ciclo de vida", "Las estrellas jóvenes se llaman en esta fase protoestrellas. A medida que se desarrollan acumulan masa de las nubes que las rodean y crecen en lo que se denomina estrella en la secuencia principal. Las estrellas en secuencia principal, como el Sol, existen en "
							+ "un estado de fusión nuclear durante el cual emitirán energía durante miles de millones de años, mientras convierten el hidrógeno a helio. Las estrellas evolucionan durante miles de millones de años. Cuando finaliza su fase de secuencia principal pasan a través de otros estados de "
							+ "existencia en función de su tamaño y otras características. Cuanto mayor sea la masa de una estrella, menor será su intervalo de vida. A medida que las estrellas avanzan hacia el final de sus vidas, gran parte de su hidrógeno se ha convertido en helio. El helio se hunde en el "
							+ "núcleo de la estrella aumentando su temperatura y provocando la expansión de su capa exterior. Estas estrellas grandes e hinchadas se conocen como gigantes rojas.", ""),
					new InfoWiki("sol", "Comparado con las mil millones de estrellas del universo, el Sol pasa desapercibido. Sin embargo, para la Tierra y otros planetas de alrededor, el Sol es un poderoso centro de atención: su luz da vida, calor y mantiene unido el sistema solar. A pesar de bañar de luz y calor "
							+ "el planeta Tierra y, por tanto, ser nuestra fuente de vida, el Sol aún oculta grandes misterios que aún no hemos logrado comprender. El Sol es una estrella enorme. Con un diámetro de 1,4 millones de kilómetros podría albergar a 109 planetas en su superficie. Si fuera hueco, más de un "
							+ "millón de Tierras podrían vivir en su interior, pero no lo es. Está relleno de gases calientes que representan más del 99,8 por ciento de la masa total del sistema solar. ¿A qué llamamos caliente? La temperatura alcanza los 5500 grados centígrados en la superficie y más de 15,5 millones "
							+ "de grados centígrados en el núcleo. En el núcleo del Sol, se producen reacciones de fusión en las que el hidrógeno se transforma en helio, que genera la energía. Unas pequeñas partículas de luz llamadas fotones transportan esta energía a través de la zona radiante hasta la capa superior "
							+ "del interior del Sol, la zona convectiva. Ahí, el movimiento de los gases hirviendo (como en una lámpara de lava) lleva la energía a"
							+ " la superficie. Este viaje dura más de un millón de años.", "")	
					);
					ApartadoWiki planetas = new ApartadoWiki("Planetas");
					planetas.setInformacion(infoPlanetas);
					ApartadoWiki galaxias = new ApartadoWiki("Galaxias");
					galaxias.setInformacion(infoGalaxias);
					ApartadoWiki satelites = new ApartadoWiki("Satélites");
					satelites.setInformacion(infoSatelites);
					ApartadoWiki estrellas = new ApartadoWiki("Estrellas");
					estrellas.setInformacion(infoEstrellas);
			repositorioApartado.saveAll( Arrays.asList(planetas, galaxias, satelites, estrellas));

			
		};
	}
}
