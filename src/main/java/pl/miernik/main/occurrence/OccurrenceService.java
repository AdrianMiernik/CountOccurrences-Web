package pl.miernik.main.occurrence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OccurrenceService {
    private final OccurrenceRepository repository;

    @Autowired
    public OccurrenceService(OccurrenceRepository repository) {
        this.repository = repository;
    }

    public String clear(String phrase) {
        return phrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().trim();
    }

    public void save(Occurrence occurrence) {
        repository.save(occurrence);
    }

    public Map<Character, Integer> map(String keyword, String sentence) {
        HashMap hashMap = new HashMap();
        int sentenceLength = sentence.length();
        int[] charOccurrence = new int[keyword.length()];
        int totalOccurrence = 0;

        for (int i = 0; i < sentenceLength; i++) {
            char currentChar = sentence.charAt(i);
            for (int j = 0; j < keyword.length(); j++) {
                char find = keyword.charAt(j);
                if (currentChar == find) {
                    charOccurrence[j]++;
                    totalOccurrence++;

                    hashMap.put(find, charOccurrence[j]);

                    break;
                }
            }
        }
        return hashMap;
    }

    public Integer getLengthWithoutSpecial(String keyword, String sentence) {
        int sentenceLength = sentence.length();
        int[] charOccurrence = new int[keyword.length()];
        int totalOccurrence = 0;

        for (int i = 0; i < sentenceLength; i++) {
            char currentChar = sentence.charAt(i);
            for (int j = 0; j < keyword.length(); j++) {
                char find = keyword.charAt(j);
                if (currentChar == find) {
                    charOccurrence[j]++;
                    totalOccurrence++;
                    break;
                }
            }
        }
        return totalOccurrence;
    }
}