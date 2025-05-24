package com.chatbot.rag_ai_chatbot_backend.ingestion;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentIngestionService implements CommandLineRunner {

    @Value("classpath:/pdf/sample1.pdf")
    private Resource resourcePdf;

    private final VectorStore vectorStore;

    public DocumentIngestionService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }


    @Override
    public void run(String... args) {

        // Reading the pdf
        System.out.println("Reading Pdf file Start......");
        TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(resourcePdf);
        System.out.println("Reading Pdf file Finish......");

        // Split the pdf content into chunks
        System.out.println("Split Content Start......");
        TextSplitter textSplitter = new TokenTextSplitter();
        List<Document> chunks = textSplitter.split(tikaDocumentReader.read());
        System.out.println("Reading Pdf file Finish......");

        // Converting chunks into embedding vectors and Store the data in the vector database
        System.out.println("Embedding chunks and Store Start......");
        vectorStore.accept(chunks);
        System.out.println("Embedding chunks and Store Finish......");

    }
}
