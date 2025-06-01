-- Create table for job questions
CREATE TABLE job_question (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    job_post_id BIGINT NOT NULL,
    question_text TEXT NOT NULL,
    question_type VARCHAR(50) NOT NULL DEFAULT 'MULTIPLE_CHOICE', -- MULTIPLE_CHOICE, SINGLE_CHOICE, TEXT
    is_required BOOLEAN DEFAULT FALSE,
    order_number INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (job_post_id) REFERENCES job_post(id) ON DELETE CASCADE
);

-- Create table for answers
CREATE TABLE job_answer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    question_id BIGINT NOT NULL,
    answer_text TEXT NOT NULL,
    is_correct BOOLEAN DEFAULT FALSE,
    order_number INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (question_id) REFERENCES job_question(id) ON DELETE CASCADE
);

-- Create index for better query performance
CREATE INDEX idx_job_question_job_post ON job_question(job_post_id);
CREATE INDEX idx_job_answer_question ON job_answer(question_id); 