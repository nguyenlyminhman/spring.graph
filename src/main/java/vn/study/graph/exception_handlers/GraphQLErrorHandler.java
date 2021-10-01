package vn.study.graph.exception_handlers;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphQLErrorHandler {

    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError throwGraphQLException(GraphQLException e) {
        return new ThrowableGraphQLError(e);
    }

    @ExceptionHandler(RuntimeException.class)
    public ThrowableGraphQLError throwRuntimeException(RuntimeException  e) {
        return new ThrowableGraphQLError(e, "Internal Error");
    }

}
