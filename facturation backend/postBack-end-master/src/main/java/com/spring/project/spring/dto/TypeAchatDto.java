package com.spring.project.spring.dto;

import com.spring.project.spring.entities.TypeAchat;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeAchatDto {
    private Integer id ;
    private  String achatType ;


    public static TypeAchat toEntity (TypeAchatDto typeAchatDto)

    {
        if(typeAchatDto==null)
        {
            return null;
            }
            TypeAchat typeAchat=new TypeAchat();
        typeAchat.setId(typeAchatDto.getId()!=null? typeAchat.getId() : null);
        typeAchat.setAchatType(typeAchatDto.getAchatType());
        return typeAchat;
    }

    public static TypeAchatDto fromEntity (TypeAchat typeAchat)

    {
        if(typeAchat==null)
        {
            return null;
        }
      return TypeAchatDto.builder()
              .id(typeAchat.getId())
              .achatType(typeAchat.getAchatType())
              .build();
    }



}
