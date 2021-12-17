FROM python
RUN apt-get update
RUN apt-get install sudo
RUN adduser --disabled-password --gecos '' admin
RUN adduser admin sudo
RUN echo '%sudo ALL=(ALL) NOPASSWD:ALL' >> /etc/sudoers
RUN pip install coverage
USER admin
