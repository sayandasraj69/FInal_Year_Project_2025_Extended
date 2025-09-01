package com.sayandas.Final.Year.Project.Entities.DoctorEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schId;
    private String weekDay;

    @ManyToOne
    @JoinColumn(name = "docId")
    private Doctors doctor;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Timings> timings;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointments> appointments;

    @Override
    public String toString() {
        return "Schedule{" +
                "schId=" + schId +
                ", weekDay='" + weekDay + '\'' +
                // Do NOT include timings or doctor here
                '}';
    }
}

// Schedule : [
//      {
//          "schId": ,
//          "weekDay": ,
//          "timings": [
//                          {
//                              "timingId": ,
//                              "timeRange":,
//                              "NoOfPatients:",
//                              "city":,
//                              "center":
//                            },
//                            {
//                              "timingId": ,
//                              "timeRange":,
//                              "NoOfPatients:",
//                              "city":,
//                              "center":
//                            }
//          ]
//      },
//      {
//          "schId": ,
//          "weekDay": ,
//          "timings": [
//                          {
//                              "timingId": ,
//                              "timeRange":,
//                              "NoOfPatients:",
//                              "city":,
//                              "center":
//                            },
//                            {
//                              "timingId": ,
//                              "timeRange":,
//                              "NoOfPatients:",
//                              "city":,
//                              "center":
//                            }
//          ]
//      }
// ]
