package com.apress.springrecipes.board.web;

import com.apress.springrecipes.board.config.MessageBoardConfiguration;
import com.apress.springrecipes.board.web.config.MessageBoardWebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by marten on 06-06-14.
 */
public class MessageBoardApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {MessageBoardConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {MessageBoardWebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/"};
    }
}
