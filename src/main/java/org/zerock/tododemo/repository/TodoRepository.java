package org.zerock.tododemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.tododemo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
