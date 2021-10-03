package vn.study.graph.exception_handlers;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.StringWriter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class ToDoGraphQLErrorHandler implements GraphQLErrorHandler {
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        return errors.stream().map(this::getNested).collect(Collectors.toList());
    }

    private GraphQLError getNested(GraphQLError graphQLError) {
        if (graphQLError instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching exErr = (ExceptionWhileDataFetching) graphQLError;
            Throwable throwable = exErr.getException();
            if (throwable instanceof GraphQLError) {
                return (GraphQLError) exErr.getException();
            }

            if (throwable instanceof ConstraintViolationException) {
                ConstraintViolationException constraintViolationException = (ConstraintViolationException) throwable;
                return new GenericGraphQLError(getConstraintViolationMessage(constraintViolationException));
            }
        }

        return graphQLError;
    }

    private String getConstraintViolationMessage(ConstraintViolationException constraintViolationException) {
        StringWriter sw = new StringWriter();
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
        for (ConstraintViolation<?> s : constraintViolations) {
            sw.write(s.getMessage());
        }
        return sw.toString();
    }
}
