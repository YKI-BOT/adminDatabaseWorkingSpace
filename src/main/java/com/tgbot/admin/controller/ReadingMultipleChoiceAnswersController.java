package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ReadingMultipleChoiceAnswer;
import com.tgbot.admin.database.entity.ReadingMultipleChoiceQuestion;
import com.tgbot.admin.database.interfaces.ReadingMultipleChoiceAnswerRepository;
import com.tgbot.admin.database.interfaces.ReadingMultipleChoiceQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reading_multiple_choice_answers")
public class ReadingMultipleChoiceAnswersController {

    private final ReadingMultipleChoiceAnswerRepository repository;
    private final ReadingMultipleChoiceQuestionRepository questionRepository;

    @Autowired
    public ReadingMultipleChoiceAnswersController(ReadingMultipleChoiceAnswerRepository repository,
                                                  ReadingMultipleChoiceQuestionRepository questionRepository) {
        this.repository = repository;
        this.questionRepository = questionRepository;
    }

    @GetMapping
    public List<ReadingMultipleChoiceAnswerDTO> getAll() {
        List<ReadingMultipleChoiceAnswer> answers = repository.findAll();
        return answers.stream()
                .map(answer -> new ReadingMultipleChoiceAnswerDTO(
                        answer.getId(),
                        answer.getText(),
                        answer.getQuestion().getId()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ReadingMultipleChoiceAnswerDTO create(@RequestBody ReadingMultipleChoiceAnswerDTO answerDTO) {
        ReadingMultipleChoiceQuestion question = questionRepository.findById(answerDTO.getQuestionId())
                .orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + answerDTO.getQuestionId()));

        ReadingMultipleChoiceAnswer answer = new ReadingMultipleChoiceAnswer();
        answer.setText(answerDTO.getText());
        answer.setQuestion(question);

        ReadingMultipleChoiceAnswer savedAnswer = repository.save(answer);
        return new ReadingMultipleChoiceAnswerDTO(
                savedAnswer.getId(),
                savedAnswer.getText(),
                savedAnswer.getQuestion().getId()
        );
    }

    @PutMapping("/{id}")
    public ReadingMultipleChoiceAnswerDTO update(@PathVariable Long id, @RequestBody ReadingMultipleChoiceAnswerDTO answerDTO) {
        ReadingMultipleChoiceAnswer answer = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Answer not found with id: " + id));

        ReadingMultipleChoiceQuestion question = questionRepository.findById(answerDTO.getQuestionId())
                .orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + answerDTO.getQuestionId()));

        answer.setText(answerDTO.getText());
        answer.setQuestion(question);

        ReadingMultipleChoiceAnswer updatedAnswer = repository.save(answer);
        return new ReadingMultipleChoiceAnswerDTO(
                updatedAnswer.getId(),
                updatedAnswer.getText(),
                updatedAnswer.getQuestion().getId()
        );
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
