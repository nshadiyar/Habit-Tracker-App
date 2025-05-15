package com.example.Habit_Tracker_App.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
@Entity
@Table(name = "reminder")
@NoArgsConstructor
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "habit_id", nullable = false)
    private Habit habit;

    public Reminder(Habit habit, LocalTime reminderTime) {
        this.habit = habit;
        this.reminderTime = reminderTime;
    }

    private LocalTime reminderTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalTime reminderTime) {
        this.reminderTime = reminderTime;
    }
}
