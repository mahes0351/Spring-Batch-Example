package com.mahesh.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.mahesh.batch.model.TransactionDetails;
import com.mahesh.batch.repository.TransactionDetailsRepository;

@Configuration
public class SpringBatchConfig {
	
	@Value("${file.input}")
    private String fileInput;
	
	@Autowired
	private TransactionDetailsRepository repository;
	
	
	@Bean
	public FlatFileItemReader<TransactionDetails> reader() {
		FlatFileItemReader<TransactionDetails> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new ClassPathResource("data.csv"));
        itemReader.setName("TransactionReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
	}
	
	private LineMapper<TransactionDetails> lineMapper() {
        DefaultLineMapper<TransactionDetails> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("series_reference", "period", "data_values", "suppressed",
	    		  "status", "units", "magnitude", "subject", "groups",
	    		  "series_title_1", "series_title_2", "series_title_3", "series_title_4", "series_title_5");

        BeanWrapperFieldSetMapper<TransactionDetails> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(TransactionDetails.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;

    }
	
	
	@Bean
    public RepositoryItemWriter<TransactionDetails> writer() {
        RepositoryItemWriter<TransactionDetails> writer = new RepositoryItemWriter<>();
        writer.setRepository(repository);
        writer.setMethodName("save");
        return writer;
    }
	
	@Bean
	public Step Transactionstep(JobRepository jobRepository, PlatformTransactionManager transactionManager, RepositoryItemWriter writer) {
	    return new StepBuilder("Transactionstep", jobRepository)
	      .<TransactionDetails, TransactionDetails> chunk(10, transactionManager)
	      .reader(reader())
	      .processor(processor())
	      .writer(writer)
	      .build();
	}
	
	@Bean
    public CustomProcessor processor() {
        return new CustomProcessor();
    }
	
	@Bean
	public Job importUserJob(JobRepository jobRepository, Step step1) {
	    return new JobBuilder("importTRansactionsJob", jobRepository)
	      .incrementer(new RunIdIncrementer())
	      .flow(step1)
	      .end()
	      .build();
	}


}
