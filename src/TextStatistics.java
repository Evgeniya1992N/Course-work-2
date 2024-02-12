import java.util.*;

public class TextStatistics {
    public static void main(String[] args) {
        // Получаем текст от пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        // Разбиваем текст на слова
        String[] words = text.split("\\s+");

        // Считаем количество слов
        int wordCount = words.length;
        System.out.println("Количество слов в тексте: " + wordCount);

        // Создаем словарь для подсчета упоминаний слов
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Сортируем словарь по убыванию частоты и алфавиту
        List<Map.Entry<String, Integer>> sortedWordFreq = new ArrayList<>(wordFreq.entrySet());
        sortedWordFreq.sort((a, b) -> {
            int freqComparison = b.getValue().compareTo(a.getValue());
            if (freqComparison != 0) {
                return freqComparison;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });

        // Выводим топ-10 самых часто упоминаемых слов
        System.out.println("\nТоп-10 самых часто упоминаемых слов:");
        for (int i = 0; i < Math.min(10, sortedWordFreq.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWordFreq.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + ": " + entry.getValue() + " раз");
        }
    }
}
