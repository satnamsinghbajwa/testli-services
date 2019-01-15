package com.testli.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testli.aop.Loggable;
import com.testli.data.model.QuestionPaper;
import com.testli.data.repo.QuestionPaperRepository;

@Service
@Loggable
public class QuestionPaperService {

	@Autowired
	private QuestionPaperRepository questionPaperRepository;

	public QuestionPaper addQuestionPaper(QuestionPaper questionPaper) {
		return questionPaperRepository.insert(questionPaper);
	}

	public QuestionPaper updateQuestionPaper(String id, QuestionPaper questionPaper) {
		questionPaper.setId(id);
		return questionPaperRepository.save(questionPaper);
	}

	public List<QuestionPaper> getQuestionPaper(String ids) {
		List<QuestionPaper> questionPapers = new ArrayList<>();
		if (ids != null) {
			List<String> items = Stream.of(ids.split("\\s*,\\s*")).map(element -> new String(element))
					.collect(Collectors.toList());
			Iterable<QuestionPaper> findAllById = questionPaperRepository.findAllById(items);
			for (QuestionPaper questionPaper : findAllById) {
				questionPapers.add(questionPaper);
			}
		}
		return questionPapers;
	}

	public void deleteQuestionPaper(String id) {
		questionPaperRepository.deleteById(id);
	}

}
