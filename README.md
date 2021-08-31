# JAVA_Avancé

## Liste Annotation sur SpringBoot et JPA

* *@Configuration* : Sert à marquer une classe comme étant la source qe l'on va utiliser pour le *@Bean*

* *@Bean* : Une annotation permettant de spécifier ce qui doit être retourné par l'environnement de Spring 

* *@Autowired* : Permet de connecter différentes parties de l'application ensemble (constructeur et/ou méthodes d'un composant) // Injecte une instance lorsqu'on en à besoin

* *@PathVariable* :  Utilisée pour gérer les variables de modèle dans le mappage d'URI de la demande et les définir comme paramètres de méthode.

* *@Controller* : Permet de détecter automatiquement les classes d'implémentation 

* *@RestController* : @Controller + @ResponseBody

* *@RequestMapping* : Si l'on utilise cette méthode, il est nécessaire de préciser après la méthode avec *method = RequestMethod.GET/POST* 

  _exemple_ : `@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)`

* *@GetMapping* : On peut encore faire plus court avec cette Annotation : `@GetMapping("/get/{id}")`

* *@PostMapping* : pour faire une requête POST // équivalent à *method = RequestMethod.POST*

* *@DeleteMapping* :   Pour faire une requête de suppression

* *@PutMapping* :  Pour faire un requête de modification  

* *@Entity* :  Spécifie que la classe dans laquelle elle se trouve, est une entité et elle est "mappé" à une table dans une BDD.

* *@Table* : Specifie le nom de la table dans la BDD utilisé lors du mapping.

* *@Id* : Permet à JPA de reconnaitre l'Id de l'object de la classe

* *@GeneratedValue* : indique que la clé primaire est générée de façon automatique lors de l’insertion en BDD. Sans cette annotation, la valeur de l’identifiant de la clé primaire doit être affecté avant l’insertion en BDD. Elle est utilisée avec une autre annotation _@Id_ qui permet de mapper une clé primaire sur un champ unique.

* *@NotBlank* : Utilise une classe *NotBlankValidator* qui détecte si la chaine de caractères renseignés n'est pas vide 



