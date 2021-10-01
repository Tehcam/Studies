#ifndef MULTIPLE_H
#define MULTIPLE_H

int multiple(int a, int b){
	int Rep=0;
	for(int i=0; i<a; i++){
		Rep += b;
	}
	return Rep;
}

#endif // MULTIPLE