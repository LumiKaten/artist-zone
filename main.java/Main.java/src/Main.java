import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Parent class: Word
class Word {
    private String value;
    private String type;

    // Constructor
    public Word(String value, String type) {
        this.value = value;
        this.type = type;
    }

    // Getters and setters
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + ": " + value;
    }
}

// Child class: Adjective
class Adjective extends Word {
    public Adjective(String value) {
        super(value, "Adjective");
    }
}

// Child class: Noun
class Noun extends Word {
    public Noun(String value) {
        super(value, "Noun");
    }
}

// Child class: Verb
class Verb extends Word {
    public Verb(String value) {
        super(value, "Verb");
    }
}

// Child class: Sentence
class Sentence {
    private Adjective adjective;
    private Noun noun;
    private Verb verb;

    // Constructor
    public Sentence(Adjective adjective, Noun noun, Verb verb) {
        this.adjective = adjective;
        this.noun = noun;
        this.verb = verb;
    }

    // Generate the sentence
    public String generateSentence() {
        return "Draw something that is " + adjective.getValue() + ", features a " + noun.getValue() + ", and conveys the idea of '" + verb.getValue() + "'.";
    }

    @Override
    public String toString() {
        return generateSentence();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Adjective> adjectives = new ArrayList<>(); // Store adjectives
        ArrayList<Noun> nouns = new ArrayList<>(); // Store nouns
        ArrayList<Verb> verbs = new ArrayList<>(); // Store verbs
        ArrayList<Sentence> sentenceList = new ArrayList<>(); // Store sentences

        System.out.println("Welcome to the Art Idea Generator!\n");

        // Main loop
        while (true) {
            System.out.println("Are you an 'artist' or 'viewer'? Enter your role or type 'exit' to quit: ");
            String role = scanner.nextLine().toLowerCase();

            if (role.equals("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            switch (role) {
                case "artist":
                    System.out.println("Welcome, artist! Choose an option:\n1. Add words\n2. Generate an idea\n3. View all words\n4. View all ideas\n5. Exit");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter an adjective: ");
                            Adjective adjective = new Adjective(scanner.nextLine());
                            adjectives.add(adjective);

                            System.out.print("Enter a noun: ");
                            Noun noun = new Noun(scanner.nextLine());
                            nouns.add(noun);

                            System.out.print("Enter a verb: ");
                            Verb verb = new Verb(scanner.nextLine());
                            verbs.add(verb);

                            System.out.println("Words added successfully!\n");
                            break;

                        case 2:
                            if (!adjectives.isEmpty() && !nouns.isEmpty() && !verbs.isEmpty()) {
                                Random random = new Random();
                                Adjective selectedAdjective = adjectives.get(random.nextInt(adjectives.size()));
                                Noun selectedNoun = nouns.get(random.nextInt(nouns.size()));
                                Verb selectedVerb = verbs.get(random.nextInt(verbs.size()));

                                Sentence sentence = new Sentence(selectedAdjective, selectedNoun, selectedVerb);
                                sentenceList.add(sentence);

                                System.out.println("Generated Art Idea: " + sentence + "\n");
                            } else {
                                System.out.println("Not enough words to generate an idea. Add more words first!\n");
                            }
                            break;

                        case 3:
                            System.out.println("Adjectives:");
                            for (Adjective adj : adjectives) {
                                System.out.println(adj);
                            }
                            System.out.println("\nNouns:");
                            for (Noun n : nouns) {
                                System.out.println(n);
                            }
                            System.out.println("\nVerbs:");
                            for (Verb v : verbs) {
                                System.out.println(v);
                            }
                            System.out.println();
                            break;

                        case 4:
                            System.out.println("Generated Ideas:");
                            for (Sentence sentence : sentenceList) {
                                System.out.println(sentence);
                            }
                            System.out.println();
                            break;

                        case 5:
                            System.out.println("Returning to role selection.\n");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.\n");
                    }
                    break;

                case "viewer":
                    System.out.println("Welcome, viewer! Here are the ideas generated so far:");
                    for (Sentence sentence : sentenceList) {
                        System.out.println(sentence);
                    }
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid role. Please enter 'artist', 'viewer', or 'exit'.\n");
            }
        }

        scanner.close();
    }
}

//Adjectives:
// Vibrant
// Majestic
// Enigmatic
// Serene
// Dazzling
// Whimsical
// Ethereal
// Radiant
// Gloomy
// Fierce

// Nouns:
// Mountain
// Phoenix
// Galaxy
// Castle
// Ocean
// Wolf
// Butterfly
// Treehouse
// Robot
// Rose

// Verbs:
// Soaring
// Whispering
// Dancing
// Shimmering
// Roaring
// Blooming
// Racing
// Gliding
// Wandering
// Melting 

