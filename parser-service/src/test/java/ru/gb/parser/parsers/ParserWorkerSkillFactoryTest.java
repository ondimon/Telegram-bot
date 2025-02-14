package ru.gb.parser.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.parser.domain.Event;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ParserWorkerSkillFactoryTest {

    private static final String BASE_URL = "https://blog.skillfactory.ru";

    @Spy
    ParserWorkerSkillFactory parserWorkerSkillFactory;

    @Test
    void parseSkillFactoryTest() throws IOException {
        File file = new File(
                getClass().getClassLoader().getResource("html/SkillFactory.html").getFile()
        );
        Document document = Jsoup.parse(file, "UTF-8");
        Mockito.doReturn(document).when(parserWorkerSkillFactory).getPageByLink(BASE_URL);

        List<Event> eventsList = parserWorkerSkillFactory.getEvents();
        assertEquals(2, eventsList.size());

        Event event = eventsList.get(0);
        assertEquals("test name", event.getName());
        assertEquals("http://test", event.getLink());

        event = eventsList.get(1);
        assertEquals("test name 2", event.getName());
        assertEquals("http://test2", event.getLink());

    }
}