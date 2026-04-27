package com.eco.cycle.domain.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(
    ignoreUnknown = true
)
public class BaseResponseDto {
    private Object data;
    private String message;

    public static BaseResponseDtoBuilder builder() {
        return new BaseResponseDtoBuilder();
    }

    public Object getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setData(final Object data) {
        this.data = data;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseResponseDto)) {
            return false;
        } else {
            BaseResponseDto other = (BaseResponseDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BaseResponseDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    public String toString() {
        return "BaseResponseDto(data=" + this.getData() + ", message=" + this.getMessage() + ")";
    }

    public BaseResponseDto() {
    }

    public BaseResponseDto(final Object data, final String message) {
        this.data = data;
        this.message = message;
    }

    public static class BaseResponseDtoBuilder {
        private Object data;
        private String message;

        BaseResponseDtoBuilder() {
        }

        public BaseResponseDtoBuilder data(final Object data) {
            this.data = data;
            return this;
        }

        public BaseResponseDtoBuilder message(final String message) {
            this.message = message;
            return this;
        }

        public BaseResponseDto build() {
            return new BaseResponseDto(this.data, this.message);
        }

        public String toString() {
            return "BaseResponseDto.BaseResponseDtoBuilder(data=" + this.data + ", message=" + this.message + ")";
        }
    }
}