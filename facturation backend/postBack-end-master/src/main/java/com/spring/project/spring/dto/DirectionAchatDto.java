package com.spring.project.spring.dto;


import com.spring.project.spring.entities.DirectionAchat;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DirectionAchatDto {
    private Integer id;
    private String achatDirection;


    public static DirectionAchat toEntity (DirectionAchatDto directionAchatDto) {
        if (directionAchatDto == null) {
            return null;
        }

        DirectionAchat directionAchat = new DirectionAchat();
        directionAchat.setId(directionAchatDto.getId() != null ? directionAchatDto.getId() : null);
        directionAchat.setId(directionAchatDto.getId());
        directionAchat.setAchatDirection(directionAchatDto.getAchatDirection());
        return directionAchat;
    }
    public static DirectionAchatDto fromEntity(DirectionAchat directionAchat) {
        if (directionAchat== null) {
            return null;
        }
return DirectionAchatDto.builder()
        .id(directionAchat.getId())
        .achatDirection(directionAchat.getAchatDirection())
        .build();
    }
    }

