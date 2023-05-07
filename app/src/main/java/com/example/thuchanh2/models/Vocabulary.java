package com.example.thuchanh2.models;

public class Vocabulary {
    private int vocabularyID;
    private String word, definition;

    /**
     * 0: Danh từ
     * 1: Tính từ
     * 2: động từ
     * 3: trạng từ
     * 4: giới từ
     */
    private int wordType;
    private int topicID;

    public Vocabulary() {
    }

    public Vocabulary(int vocabularyID, String word, String definition, int wordType, int topicID) {
        this.vocabularyID = vocabularyID;
        this.word = word;
        this.definition = definition;
        this.wordType = wordType;
        this.topicID = topicID;
    }

    public int getVocabularyID() {
        return vocabularyID;
    }

    public void setVocabularyID(int vocabularyID) {
        this.vocabularyID = vocabularyID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getWordType() {
        return wordType;
    }

    public void setWordType(int wordType) {
        this.wordType = wordType;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }
}
