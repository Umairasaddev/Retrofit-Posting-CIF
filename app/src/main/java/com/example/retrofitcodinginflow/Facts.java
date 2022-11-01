package com.example.retrofitcodinginflow;

import com.google.gson.annotations.SerializedName;

public class Facts {

    @SerializedName("fact")
        private String fact;

        @SerializedName("length")
        private Integer length;

        public String getFact() {
            return fact;
        }

        public void setFact(String fact) {
            this.fact = fact;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }

    }


